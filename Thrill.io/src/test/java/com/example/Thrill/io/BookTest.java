package com.example.Thrill.io;

import com.example.Thrill.io.constants.BookGenre;
import com.example.Thrill.io.entities.Book;
import com.example.Thrill.io.services.BookmarkManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {
    @Test
    public void testIsKidFriendlyEligible() {
        Book book = BookmarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
        boolean isKidFriendlyEligible = book.isKidsFriendlyEligible();
        Assertions.assertEquals(false, isKidFriendlyEligible);
    }
}
