package demo.controller;

import demo.model.ProductDAO;
import demo.util.NullAwareBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Linda on 23/02/16.
 */
public class ProductAbstractController extends AbstractController {
    @Autowired
    protected ProductDAO productDAO;
}
