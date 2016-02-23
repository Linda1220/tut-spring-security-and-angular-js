package demo.controller;

import demo.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Linda on 23/02/16.
 */
public class ProductAbstractController extends AbstractController {
    @Autowired
    public ProductDAO productDAO;
}
