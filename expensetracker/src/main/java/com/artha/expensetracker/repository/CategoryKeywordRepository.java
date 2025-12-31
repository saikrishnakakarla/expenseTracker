package com.artha.expensetracker.repository;

import com.artha.expensetracker.entity.CategoryEntity;
import com.artha.expensetracker.entity.CategoryKeywordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;


public interface CategoryKeywordRepository
        extends JpaRepository<CategoryKeywordEntity, String> {

    Optional<CategoryKeywordEntity> findByKeywordIgnoreCase(String keyword);
/*
    @Query("""
    SELECT ck.category
    FROM CategoryKeywordEntity ck
    WHERE ck.keyword IN :keywords
    """)
    Optional<CategoryEntity> findFirstMatchingCategory(
            @Param("keywords") Set<String> keywords
    );*/

    @Query("""
    select c
    from CategoryEntity c
    where c.name = 'Miscellaneous'
""")
    Optional<CategoryEntity> findMiscellaneousCategory();


}

