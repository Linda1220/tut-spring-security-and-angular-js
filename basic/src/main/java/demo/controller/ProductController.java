package demo.controller;

import demo.model.Product;
import demo.model.ProductDAO;
import demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Linda on 21/02/16.
 */
@RestController
public class ProductController extends AbstractController {
    @Autowired
    public ProductDAO productDAO;

    @RequestMapping(path = "/product", method = {RequestMethod.PUT})
    public Message createProduct(String brand, String name, String price, String version, String weight, String provider) {
        Product product = new Product(brand, name, price, version, weight, provider);
        productDAO.save(product);
        return OK;
    }

    @RequestMapping(path = "/product", method = {RequestMethod.POST})
    public Message updateProduct(long id, String brand, String name, String price, String version, String weight, String provider) {
        Product product = productDAO.findOne(id);
        if(!StringUtils.isEmpty(brand)){product.setBrand(brand);}
        if(!StringUtils.isEmpty(name)){product.setName(name);}
        if(!StringUtils.isEmpty(price)){product.setPrice(price);}
        if(!StringUtils.isEmpty(version)){product.setVersion(version);}
        if(!StringUtils.isEmpty(weight)){product.setWeight(weight);}
        if(!StringUtils.isEmpty(provider)){product.setProvider(provider);}
        productDAO.save(product);
        return OK;
    }

    @RequestMapping(path = "/product", method = {RequestMethod.DELETE})
    public Message deleteProduct(long id) {
        productDAO.delete(id);
        return OK;
    }

}
