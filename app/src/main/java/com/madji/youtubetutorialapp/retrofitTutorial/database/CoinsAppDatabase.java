package com.madji.youtubetutorialapp.retrofitTutorial.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.madji.youtubetutorialapp.retrofitTutorial.database.db_data.OneCoinData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {OneCoinData.class}, version = 1, exportSchema = false)
public abstract class CoinsAppDatabase extends RoomDatabase {

    public abstract CoinsDatabaseInterface coinsDatabaseInterface();
    private static volatile CoinsAppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static CoinsAppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CoinsAppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CoinsAppDatabase.class, "one_coin_view")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                CoinsDatabaseInterface cdi = INSTANCE.coinsDatabaseInterface();
                cdi.deleteAll();
//OneCoinData(String fullName, String nickName, String amount, String dataPurchased, String purchasePrice)
                OneCoinData ocd = new OneCoinData("Bitcoin", "BTC", "100", "18.04.2022", "1234");
                cdi.insert(ocd);
                OneCoinData ocd2 = new OneCoinData("Etherum", "ETH", "400", "18.04.2022", "345");
                cdi.insert(ocd2);
            });
        }
    };

}

