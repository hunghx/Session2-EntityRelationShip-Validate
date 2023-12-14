package ra.academy.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ra.academy.dto.request.UserDto;
import ra.academy.entity.*;
import ra.academy.repository.ICatalogRepository;
import ra.academy.repository.IProductRepository;
import ra.academy.repository.IRoleRepository;
import ra.academy.repository.UserRepository;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api.demo.entity.relationship.com/v2")
public class HomeController {
    private final ICatalogRepository catalogRepository;
    private final IProductRepository productRepository;
    private final UserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final ModelMapper modelMapper;
    @GetMapping("/test")
    public String test(){
//        Catalog cat1 = new Catalog(null,"Trang sức",null);
//        Catalog cat2 = new Catalog(null,"Quần",null);
//        Product p1 = new Product(null,"Quần âu nam",new BigDecimal(100),100,"nothing",cat1);
//        Product p2 = new Product(null,"áo nữ",new BigDecimal(120),50,"nothing",cat2);
//
//        productRepository.save(p1);
//        productRepository.save(p2);


        Role role1 = new Role(null, RoleName.ADMIN);
        Role role2 = new Role(null, RoleName.USER);
        Role role3 = new Role(null, RoleName.PM);


        User user1 = new User(null,"hunghx","123456",new HashSet<>());
        user1.getRoles().add(role1);
        user1.getRoles().add(role3);

        User user2 = new User(null,"sontx","123456",new HashSet<>());
        user2.getRoles().add(role2);

        userRepository.save(user1);
        userRepository.save(user2);

        return "success";
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/catalogs")
    public List<Catalog> catalogs(){
        List<Catalog> list = catalogRepository.findAll();
        return list;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products")
    public List<Product> products(){
        return productRepository.findAll();
    }
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable String id){

        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
        }else {
            throw  new NoSuchElementException("Không có id tồn tại");
        }
        return "success";
    }
  @DeleteMapping("catalogs/{id}")
  public String deleteCatalog(@PathVariable Long id){

        if (catalogRepository.existsById(id)){
            catalogRepository.deleteById(id);
        }else {
            throw  new NoSuchElementException("Không có id tồn tại");
        }
        return "success";
    }
    @PostMapping("/add")
    public User addUser(@Valid @ModelAttribute UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
      user.setRoles(new HashSet<>());
        user.getRoles().add(roleRepository.findById(3L).orElseThrow(()-> new NoSuchElementException("Không có id tồn tại")));
        return userRepository.save(user);

    }

}
