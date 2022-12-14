/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorialpoint.point;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@RestController
public class ProductServiceController {
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        honey.setPrice(7000);
        honey.setNumber(7);
        honey.setTotal();
        productRepo.put(honey.getId(), honey);
        
        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        almond.setPrice(8000);
        almond.setNumber(5);
        almond.setTotal();
        productRepo.put(almond.getId(), almond);
        
    }
    
    // Get API
    @RequestMapping(value="/products")
    public ResponseEntity<Object> getProduct(){
       return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
    
    // Post API
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        
        if(productRepo.containsKey(product.getId())){
            return new ResponseEntity<>("ID Product" + product.getId().toString()+ "Cannot be the Same" + "please check again", HttpStatus.OK);
        }
        else{
            productRepo.put(product.getId(), product);
            return new ResponseEntity<>("Product is created Successfully", HttpStatus.CREATED);
        }
    }
    
    // PUT API
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        
        if(!productRepo.containsKey(id)){
            return new ResponseEntity<>("Product Not Found to update" + id + ",Please check again", HttpStatus.NOT_FOUND);
        }
        else{
            productRepo.remove(id);
            product.setId(id);
            productRepo.put(id, product);
            return new  ResponseEntity<>("Product is updated Successfully",HttpStatus.OK);
        }
        
    }
    
    // DELETE API
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id){
         if(!productRepo.containsKey(id)){
            return new ResponseEntity<>("Product Not Found to deleted " + id +" ,Please check again", HttpStatus.NOT_FOUND);
        }
        else{
            productRepo.remove(id);
            return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
        }
    }
}