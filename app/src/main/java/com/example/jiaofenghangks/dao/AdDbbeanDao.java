package com.example.jiaofenghangks.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.jiaofenghangks.bean.AdDbbean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "AD_DBBEAN".
*/
public class AdDbbeanDao extends AbstractDao<AdDbbean, Long> {

    public static final String TABLENAME = "AD_DBBEAN";

    /**
     * Properties of entity AdDbbean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ChapterName = new Property(1, String.class, "chapterName", false, "CHAPTER_NAME");
        public final static Property EnvelopePic = new Property(2, String.class, "envelopePic", false, "ENVELOPE_PIC");
        public final static Property Desc = new Property(3, String.class, "desc", false, "DESC");
    }


    public AdDbbeanDao(DaoConfig config) {
        super(config);
    }
    
    public AdDbbeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"AD_DBBEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"CHAPTER_NAME\" TEXT," + // 1: chapterName
                "\"ENVELOPE_PIC\" TEXT," + // 2: envelopePic
                "\"DESC\" TEXT);"); // 3: desc
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"AD_DBBEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AdDbbean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String chapterName = entity.getChapterName();
        if (chapterName != null) {
            stmt.bindString(2, chapterName);
        }
 
        String envelopePic = entity.getEnvelopePic();
        if (envelopePic != null) {
            stmt.bindString(3, envelopePic);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(4, desc);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AdDbbean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String chapterName = entity.getChapterName();
        if (chapterName != null) {
            stmt.bindString(2, chapterName);
        }
 
        String envelopePic = entity.getEnvelopePic();
        if (envelopePic != null) {
            stmt.bindString(3, envelopePic);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(4, desc);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public AdDbbean readEntity(Cursor cursor, int offset) {
        AdDbbean entity = new AdDbbean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // chapterName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // envelopePic
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // desc
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AdDbbean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setChapterName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setEnvelopePic(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDesc(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(AdDbbean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(AdDbbean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(AdDbbean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
