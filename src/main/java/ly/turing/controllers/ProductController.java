package ly.turing.controllers;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.*;
import ly.turing.util.ErrorObject;
import javax.servlet.http.HttpServletResponse;
import ly.turing.service.ProductService;
@RestController
@RequestMapping("/products")
public class ProductController  {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  public Object getAllProducts(HttpServletResponse response)
  {
  return productService.findAll();
  }
}
