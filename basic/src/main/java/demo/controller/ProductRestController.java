package demo.controller;

import demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Linda on 21/02/16.
 */
@RestController
public class ProductRestController extends ProductAbstractController {


    @RequestMapping(path = "/product", method = {RequestMethod.PUT}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Message createProduct(@RequestBody ProductDTO productDTO) {
         productDAO.save(new Product(productDTO));
        return OK;
    }

    @RequestMapping(path = "/product", method = {RequestMethod.POST})
    public Message updateProduct(long id, String brand, String name, String price1, String price2, String price3, String version, String weight, String provider1, String provider2, String provider3) {
        Product product = productDAO.findOne(id);
        if (!StringUtils.isEmpty(brand)) {
            product.setBrand(brand);
        }
        if (!StringUtils.isEmpty(name)) {
            product.setName(name);
        }
        if (!StringUtils.isEmpty(price1)) {
            product.setPrice1(price1);
        }
        if (!StringUtils.isEmpty(price2)) {
            product.setPrice2(price2);
        }
        if (!StringUtils.isEmpty(price3)) {
            product.setPrice3(price3);
        }
        if (!StringUtils.isEmpty(version)) {
            product.setVersion(version);
        }
        if (!StringUtils.isEmpty(weight)) {
            product.setWeight(weight);
        }
        if (!StringUtils.isEmpty(provider1)) {
            product.setProvider1(provider1);
        }
        if (!StringUtils.isEmpty(provider2)) {
            product.setProvider2(provider2);
        }
        if (!StringUtils.isEmpty(provider3)) {
            product.setProvider3(provider3);
        }
        productDAO.save(product);
        return OK;
    }

    @RequestMapping(path = "/product", method = {RequestMethod.DELETE})
    public Message deleteProduct(long id) {
        productDAO.delete(id);
        return OK;
    }

    @RequestMapping(path = "/products", method = {RequestMethod.GET})
    public Iterable<Product> queryAll() {
        Iterable<Product> all = productDAO.findAll();
        return all;
    }

    @RequestMapping(path = "/product", method = {RequestMethod.GET})
    public Product queryOne(long id) {
        Product product = productDAO.findOne(id);
        return product;
    }

}
