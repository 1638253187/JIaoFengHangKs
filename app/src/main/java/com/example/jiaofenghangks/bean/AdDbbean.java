package com.example.jiaofenghangks.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class AdDbbean {
    @Id(autoincrement = true)
    private Long id;
    private String chapterName;
    private String envelopePic;
    private String desc;
    @Generated(hash = 1974969971)
    public AdDbbean(Long id, String chapterName, String envelopePic, String desc) {
        this.id = id;
        this.chapterName = chapterName;
        this.envelopePic = envelopePic;
        this.desc = desc;
    }
    @Generated(hash = 1213264803)
    public AdDbbean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getChapterName() {
        return this.chapterName;
    }
    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
    public String getEnvelopePic() {
        return this.envelopePic;
    }
    public void setEnvelopePic(String envelopePic) {
        this.envelopePic = envelopePic;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

}
