package demo.demo.dto.request.category;

import jakarta.validation.constraints.NotNull;

public class CategoryRequest {
    @NotNull
    private String name;
    public CategoryRequest(String name) {
        this.name = name;
    }

    public CategoryRequest() {
    }

    public String getName() {
        return name;
    }
}
