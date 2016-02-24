package demo.controller;

import demo.model.*;
import demo.util.NullAwareBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Linda on 21/02/16.
 */
@RestController
public class ProductRestController extends ProductAbstractController {


    @RequestMapping(path = "/product", method = {RequestMethod.PUT})
    public Message createProduct(@RequestBody ProductDTO productDTO) {
        productDAO.save(new Product(productDTO));
        return OK;
    }

    @RequestMapping(path = "/product", method = {RequestMethod.POST})
    public Message updateProduct(@RequestBody ProductDTO productDTO) throws InvocationTargetException, IllegalAccessException {
        Product product = productDAO.findOne(productDTO.getId());
        NullAwareBeanUtil.copyProperties(productDTO, product);
        productDAO.save(product);
        return OK;
    }

    @RequestMapping(path = "/product", method = {RequestMethod.DELETE})
    public Message deleteProduct(@RequestBody ProductDTO productDTO) {
        productDAO.delete(Long.valueOf(productDTO.getId()));
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
