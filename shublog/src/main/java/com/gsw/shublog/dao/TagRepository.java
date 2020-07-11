package com.gsw.shublog.dao;
import com.gsw.shublog.po.Type;
import com.gsw.shublog.po.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);

    @Query("select t from s_tag t")
    List<Tag> findTop(Pageable pageable);
}

