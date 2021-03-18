package com.example.test.Information;

public class Information {
    private String clickName;
    private int clickId;
    private String rootName;
    private int rootImageId;
    private int thingImageId;
    private String rootContext;
    public static final int TYPE_CLICK = 1;
    public static final int TYPE_INFORMATION = 2;
    public static final int TYPE_TIP = 3;
    private int type;
    private String tips;

    public Information(String clickName, int clickId, int type) {
        this.clickId = clickId;
        this.clickName = clickName;
        this.type = type;
    }

    public Information(String tips, int type) {
        this.tips = tips;
        this.type = type;
    }

    public Information(String rootName, int rootImageId, String rootContext,
                       int thingImageId, int type) {
        this.rootContext = rootContext;
        this.rootName = rootName;
        this.rootImageId = rootImageId;
        this.thingImageId = thingImageId;
        this.type = type;
    }

    public String getTips() {
        return tips;
    }

    public int getRootImageId() {
        return rootImageId;
    }

    public int getThingImageId() {
        return thingImageId;
    }

    public String getRootContext() {
        return rootContext;
    }

    public String getRootName() {
        return rootName;
    }

    public int getType() {
        return type;
    }

    public String getClickName() {
        return clickName;
    }

    public int getClickId() {
        return clickId;
    }
}
