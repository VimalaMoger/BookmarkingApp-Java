package com.example.Thrill.io.entities;

import com.example.Thrill.io.partner.Shareable;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
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

    public DownloadStatus getDownloadStatus() {
        return downloadStatus;
    }

    public void setDownloadStatus(DownloadStatus downloadStatus) {
        this.downloadStatus= downloadStatus;
    }

    public void setHtmlPage(String htmlPage) {
        this.htmlPage= htmlPage;

    }
    public String getHtmlPage() {
        return this.htmlPage;
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
