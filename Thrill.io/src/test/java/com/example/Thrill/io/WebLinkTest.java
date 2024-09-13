package com.example.Thrill.io;


import com.example.Thrill.io.entities.WebLink;
import com.example.Thrill.io.services.BookmarkManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WebLinkTest {
    @Test
    public void testIsKidFriendlyEligible(){
        WebLink webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com");
        boolean isKidEligibleForWatching = webLink.isKidsFriendlyEligible();
        Assertions.assertEquals(true, isKidEligibleForWatching);
    }

}
