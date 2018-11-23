package com.hva.joris.studentportal;

import android.os.Parcel;
import android.os.Parcelable;

public class PortalObject implements Parcelable {
    private String name;
    private String url;

    public PortalObject(String name, String url) {
        this.name = name;
        this.url = url;
    }

    protected PortalObject(Parcel in) {
        name = in.readString();
        url = in.readString();
    }

    public static final Creator<PortalObject> CREATOR = new Creator<PortalObject>() {
        @Override
        public PortalObject createFromParcel(Parcel in) {
            return new PortalObject(in);
        }

        @Override
        public PortalObject[] newArray(int size) {
            return new PortalObject[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        if (url.startsWith("http://") || url.startsWith("https://")) {
            return url;
        }
        return "http://" + url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.url);
    }

    @Override
    public String toString() {
        return name;
    }
}
