package com.example.Thrill.io.entities;

import com.example.Thrill.io.partner.Shareable;
import lombok.Data;

@Data
public class WebLink extends Bookmark implements Shareable {
    private String url;
    private String host;
    private String htmlPage;

    //download only weblinks that haven't been, status is NOT_ATTEMPTED by default
    private DownloadStatus downloadStatus = DownloadStatus.NOT_ATTEMPTED;// not downloaded yet

    public enum DownloadStatus{
        NOT_ATTEMPTED,
        SUCCESS,
        FAILED,
        NOT_ELIGIBLE; //NOT ELIGIBLE FOR DOWNLOAD
    }

    @Override
    public String toString() {
        return "WebLink [ url=" + url + ", host=" + host + "]";
    }

    //stub
    public boolean isKidsFriendlyEligible() {
        if(host.contains("adult")) {
            return false;
        }
        return true;
    }

    @Override
    public String getItemData() {
        // using xml -extensible mark up language
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
        builder.append("<type>WebLink</type>");
        builder.append("<title>").append(getTitle()).append("</title>");
        builder.append("<url>>").append(url).append("</url>");
        builder.append("<host>").append(host).append("</host>");
        builder.append("</item");
        return builder.toString();
    }
}
