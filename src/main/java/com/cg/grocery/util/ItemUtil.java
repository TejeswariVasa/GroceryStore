package com.cg.grocery.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.grocery.entity.ItemDetails;
import com.cg.grocery.entity.Items;

@Component
public class ItemUtil {
	public static ItemDetails toDetails(ItemDetails add) {
        return new ItemDetails(add.getItemid(),add.getItemName(),add.getPrice(),add.getQuantity());



                }

public static List<ItemDetails> toDetails(Collection<ItemDetails> item) {
 List<ItemDetails> detailList = new ArrayList<>();
    for (ItemDetails item1 : item) {
       ItemDetails details = toDetails(item1);
        System.out.println(details);
        detailList.add(details);
    }
    return detailList;
}




}


