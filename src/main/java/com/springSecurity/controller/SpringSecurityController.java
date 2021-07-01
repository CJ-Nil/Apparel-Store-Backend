package com.springSecurity.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springSecurity.fileSystem.*;
import com.springSecurity.jwt.JwtUtil;
import com.springSecurity.models.AuthenticationRequest;
import com.springSecurity.models.AuthenticationResponse;
import com.springSecurity.models.RequestParameter;
import com.springSecurity.dao.*;
import com.springSecurity.model.*;
import com.springSecurity.*;
@CrossOrigin
@RestController
public class SpringSecurityController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private ProductRepo repo;
	@Autowired
	private BrandRepo brepo;
	@Autowired
	private UserRepository urepo;
	@Autowired
	private ComodityRepo crepo;
	@Autowired
	private CustomerRepo custrepo;
	@Autowired
	private HistoryRepo hrepo;
	@Autowired
	private OrderRepo orepo;
	@GetMapping("/")
	public String home() {
		return ("<h1>Welcome Home</h1>");
	}
	
	@GetMapping(path="/user")
	public String user() {
		return ("<h1>Welcome User</h1>"
				+ "<h2><a href='/logout'>logout</a></h2>");
	}
	
	@GetMapping(path="/admin")
	public String admin() {
		return ("<h1>Welcome Admin</h1>"
				+ "<h2><a href='/logout'>logout</a></h2>");
	}
	@GetMapping("/error")
	public String error() {
		return ("Access Denied!");
	}
	@Autowired
	private FileStorageService fileStorageService;
	@GetMapping("/brands")
	public List<Brand> getBrands()
	{
		return brepo.findAll();
			
	}
	@GetMapping(path="/comodity")
	public List<Comodity> getComodity()
	{
		return crepo.findAll();
			
	}
	@PutMapping("/files")
	public ResponseEntity<FileResponse> uploadFile(@RequestParam("file") MultipartFile file){
		String fileName = fileStorageService.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/files/")
				.path(fileName)
				.toUriString();
		
		FileResponse fileResponse = new FileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
		return new ResponseEntity<FileResponse>(fileResponse,HttpStatus.OK);
	}
	
	@GetMapping("/files/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName,HttpServletRequest request){
		
		Resource resource = fileStorageService.loadFileAsResource(fileName);
		
		String contentType = null;
		
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		}catch(IOException ex) {
			System.out.println("Could not determine fileType");
		}
		
		if(contentType==null) {
			contentType = "application/octet-stream";
		}
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.body(resource);
	}
	@DeleteMapping("/deleteproduct/{pid}")
	public List<Product> deleteProduct(@PathVariable int pid)
	{
		Product p = repo.getOne(pid);
		try {
			repo.delete(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return repo.findAll();
	}
	@PostMapping(path="/addproduct",consumes= {"application/json"})
	public List<Product> addProduct(@RequestBody Product p)
	{
		repo.save(p);
		return repo.findAll();
	}
	@PostMapping(path="/addorder",consumes= {"application/json"})
	public String addOrder(@RequestBody Order o)
	{
		orepo.save(o);
		return "sucess";
	}
	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return orepo.findAll();
	}
	@GetMapping("/orders/{username}/")
	public List<Order> findOrderByUsername(@PathVariable("username")String username){
		return orepo.findAllById(username);
	}
	@PutMapping(path="/addhistory",consumes= {"application/json"})
	public List<History> addHistory(@RequestBody History h)
	{
		hrepo.save(h);
		return hrepo.findAllHistoryByUsername(h.getUsername());
	}
	@PutMapping("/updateproduct")
	public List<Product> saveOrUpdateProduct(@RequestBody Product product)
	{
		repo.save(product);
		return repo.findAll();
	}
	@GetMapping(path="/products")
	public List<Product> getProducts()
	{
		return repo.findAll();
			
	}
	@GetMapping("/history/{username}")
	public List<History> getHistoryByUsername(@PathVariable("username")String username){
		return hrepo.findAllHistoryByUsername(username);
	}
	@GetMapping(path="/products/{comodity}")
	public List<Product> getProductsByComodity(@PathVariable("comodity")String comodity)
	{
		return repo.findProductsByComodity(comodity);
			
	}
	@GetMapping(path="/newproducts")
	public List<Product> newArrivals()
	{
		return repo.newArrivals();
			
	}
	@GetMapping(path="/searchproducts/{keyword}")
	public List<Product> searchProducts(@PathVariable("keyword")String keyword)
	{
		return repo.searchProducts(keyword);
			
	}
	@PostMapping(path="/searchproductsbyfilter")
	public List<Product> searchProducts(@RequestBody RequestParameter request )
	{
		return repo.findProductsByComodityAndGender(request.getGen(),request.getComo());
			
	}
	@RequestMapping("/product/{pid}")
	public Optional<Product> getProduct(@PathVariable("pid")int p_code)
	{
		return repo.findById(p_code);
	}
	@GetMapping("/brand/{bid}")
	public Optional<Brand> getBrand(@PathVariable("bid")int b_id)
	{
		return brepo.findById(b_id);
	}
	@PostMapping("/addcustomer")
	public Optional<Customer> addCustomer(@RequestBody Customer c) {
		custrepo.save(c);
		return custrepo.findById(c.getUsername());
	}
	@GetMapping("/customer/{username}")
	public Optional<Customer> getProduct(@PathVariable("username")String username)
	{
		return custrepo.findById(username);
	}
	@PutMapping("/updatecustomer")
	public Optional<Customer> saveOrUpdateCustomer(@RequestBody Customer c)
	{
		custrepo.save(c);
		return custrepo.findById(c.getUsername());
	}
	@PostMapping("/adduser")
	public UserPrinciple addUser(@RequestBody AuthenticationRequest authenticationRequest) {
		urepo.save(new User(authenticationRequest.getUsername(),authenticationRequest.getPassword(),"ROLE_USER"));
		return (UserPrinciple) userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	}
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		
		try {
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
			);
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Incorrect username or password",e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		String role = authorities.stream().findFirst().get().toString();
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt,role));
		
	}
}
