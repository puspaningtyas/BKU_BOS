package com.project.bku.repository;//package com.project.bku.repository;

        import com.project.bku.model.DBFile;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}
