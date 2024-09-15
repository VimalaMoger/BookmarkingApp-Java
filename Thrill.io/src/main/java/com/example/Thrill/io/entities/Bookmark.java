package com.example.Thrill.io.entities;

import com.example.Thrill.io.constants.KidFriendlyStatus;
import lombok.Data;

@Data
public abstract class Bookmark {

    private long id;
    private String title;
    private String profileUrl;
    private KidFriendlyStatus kidFriendlyStatus =KidFriendlyStatus.UNKNOWN;
    private User kidFriendlyMarkedBy;
    private User sharedBy;

    public abstract boolean isKidsFriendlyEligible();

}
