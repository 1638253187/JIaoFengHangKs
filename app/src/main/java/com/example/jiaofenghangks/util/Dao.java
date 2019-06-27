package com.example.jiaofenghangks.util;

import com.example.jiaofenghangks.bean.AdDbbean;
import com.example.jiaofenghangks.common.AdApp;
import com.example.jiaofenghangks.dao.AdDbbeanDao;
import com.example.jiaofenghangks.dao.DaoMaster;
import com.example.jiaofenghangks.dao.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class Dao {
    public static Dao dao;
    public static AdDbbeanDao adDbbeanDao;

    public static Dao getDao() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    dao = new Dao();
                }
            }
        }
        return dao;
    }

    public Dao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(AdApp.getAdApp(), "android.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());

        DaoSession daoSession = daoMaster.newSession();
        adDbbeanDao = daoSession.getAdDbbeanDao();
    }

    public static long insert(AdDbbean adDbbean) {
        if (!isHas(adDbbean)) {
            long l = adDbbeanDao.insertOrReplace(adDbbean);
            return l;
        }
        return -1;
    }




    public static List<AdDbbean> query() {
        List<AdDbbean> list = adDbbeanDao.queryBuilder().list();
        return list;
    }

    public static boolean isHas(AdDbbean adDbbean) {
        List<AdDbbean> list = adDbbeanDao.queryBuilder().where(AdDbbeanDao.Properties.Desc.eq(adDbbean.getDesc())).list();
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }
}
