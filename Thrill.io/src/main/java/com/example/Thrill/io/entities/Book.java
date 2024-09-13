package com.example.Thrill.io.entities;

import com.example.Thrill.io.constants.BookGenre;
import com.example.Thrill.io.partner.Shareable;
import lombok.Setter;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

@Setter
public class Book extends Bookmark implements Shareable {

    private String image_url;
    private String publisher;
    private int publicationYear;
    private String[] authors;
    private BookGenre genre;
    private double amazonRating;

    public Book() {}

    @Override
    public String toString() {
        return "Book [image_url=" + image_url + ", publicationYear = " + publicationYear + ", publisher = " + publisher
                + ", authors = " + Arrays.toString(authors) + ", genre = " + genre + ", amazonRating = " + amazonRating + "]";
    }

    @Override
    public boolean isKidsFriendlyEligible() {
        if (genre.equals(BookGenre.PHILOSOPHY) || genre.equals(BookGenre.SELFT_HELP)){
            return false;
        }
        return true;
    }

    @Override
    public String getItemData() {
        //xml string using StringBuilder
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
        builder.append("<type>Book</type>");
        builder.append("<title>").append(getTitle()).append("</title>");
        builder.append("<authors>").append(StringUtils.join(authors,",")).append("</authors>");
        builder.append("<publisher>").append(publisher).append("</title>");
        builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
        builder.append("<genre>").append(genre).append("</genre>");
        builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");
        builder.append("</item");
        return builder.toString();
    }
}
