package anno;

@ClassLevelAnno(name = "entity1")
public class AnnoEntity {
    @FieldLevelAnno(name="fname")
    private String name;
}
