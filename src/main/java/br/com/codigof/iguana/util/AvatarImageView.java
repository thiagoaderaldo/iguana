/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.util;

/**
 *
 * @author thiago
 */
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class AvatarImageView {
     
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            images.add("avatar" + i + ".png");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}