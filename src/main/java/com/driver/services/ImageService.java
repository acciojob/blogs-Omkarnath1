package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog = blogRepository2.findById(blogId).get();
        Image image= new Image(description,dimensions);
        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return image;

    //not adding image_repo because adding blog-repo will do it by cascading effect;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        String [] scrarray = screenDimensions.split("X");
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image = imageRepository2.findById(id).get();

        String imageDimensions = image.getDimensions();
        String [] imgarray = imageDimensions.split("X");

        int scrl = Integer.parseInt(scrarray[0]); //A -- > integer
        int scrb = Integer.parseInt(scrarray[1]); //B -- > integer

        int imgl = Integer.parseInt(imgarray[0]); //A -- > integer
        int imgb = Integer.parseInt(imgarray[1]); //B -- > integer

        return no_Images(scrl,scrb,imgl,imgb);
    }
    private int no_Images(int scrl, int scrb, int imgl, int imgb) {
        int lenC = scrl/imgl; //
        int lenB = scrb/imgb;
        return lenC*lenB;
    }
}
