package com.example.finance_tracker.categories;


import com.example.finance_tracker.user.User;
import com.example.finance_tracker.user.UserResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/categories/")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponse createCategory(@RequestBody Category category, @RequestParam Long userId){
        Category saved = categoryService.createCategory(category,userId);
        User user = saved.getUser();
        UserResponse userResponse = new UserResponse(user.getId(), user.getEmail(), user.getCurrencyCode(), user.getCreatedAt());
        return new CategoryResponse(saved.getId(),userResponse,saved.getName(),saved.getType(),saved.getIconColor());
    }
}
