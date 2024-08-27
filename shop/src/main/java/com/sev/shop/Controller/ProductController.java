import com.sev.shop.Product;
import com.sev.shop.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    @Autowired
    public ProductService productService;
    private Object ProductService;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
 @GetMapping("/{id}")
 public ResponseEntity<Product> getProduct(@PathVariable Long id) {
     Optional<Product> product = Optional.ofNullable(ProductService.getProductById(id));
     return product.map(ResponseEntity::ok)
             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
 }
@PutMapping("/{id}")
public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
    product.setId(id);
    return ProductService.updateProduct(product);
}

@DeleteMapping("/{id}")
public void deleteProduct(@PathVariable Long id) {
    ProductService.deleteProduct(id);
}

@GetMapping
public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = ProductService.getAllProducts();
    return new ResponseEntity<>(products, HttpStatus.OK);
}
}
