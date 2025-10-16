package wiscom.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import wiscom.backend.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Work extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;
    private String teamName;
    private  String shortDescription;
    private String midDescription;
    private String githubUrl;
    private String instagramUrl;
    private String imageUrl;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "work_category", joinColumns = @JoinColumn(name = "work_id"))
    @Column(name = "category")
    private List<CategoryEnum> categories;

    @Lob
    private String description;

    @OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
    private List<Developer> developers = new ArrayList<>();

    @OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
    private List<Image> imageUrls = new ArrayList<>();
}
