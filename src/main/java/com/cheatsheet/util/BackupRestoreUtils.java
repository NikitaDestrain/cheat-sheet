package com.cheatsheet.util;

// todo add logic of backup / restore from json file
public class BackupRestoreUtils {
    private static volatile BackupRestoreUtils instance;

    private BackupRestoreUtils() {
    }

    public static BackupRestoreUtils getInstance() {
        BackupRestoreUtils localInstance = instance;
        if (localInstance == null) {
            synchronized (BackupRestoreUtils.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new BackupRestoreUtils();
                }
            }
        }
        return localInstance;
    }
}
