package com.zqh.excel.linkage;

import java.util.List;

public class KnowledgeCategoryDTO {
    private AssistantKnowledgeCategory category;
    private List<KnowledgeCategoryDTO> subCategoryList;

    public AssistantKnowledgeCategory getCategory() {
        return category;
    }

    public void setCategory(AssistantKnowledgeCategory category) {
        this.category = category;
    }

    public List<KnowledgeCategoryDTO> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<KnowledgeCategoryDTO> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}