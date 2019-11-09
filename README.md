# spring-boot-jpa-audit-db

This project is an extension of the Spring Data JPA project to allow access to entity revisions managed by spring data envers.

The core feature of the module consists of an implementation of the `RevisionRepository` of Spring Data Commons.

=== Gradle configuration

In order to enable Envers features we will first include spring-data-envers as dependency:

--

implementation 'org.springframework.data:spring-data-envers:2.2.1.RELEASE'

--
Next is to inform Spring Boot that we would like do enable Envers' features. This can be done by annotating a @Configuration class with @EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class).

== Getting Started

public interface RevisionRepository<T, ID extends Serializable, N extends Number & Comparable<N>> {

	Revision<N, T> findLastChangeRevision(ID id);

	Revisions<N, T> findRevisions(ID id);

	Page<Revision<N, T>> findRevisions(ID id, Pageable pageable); 
  }


You can pull in this functionality to your repositories by simply additionally extending the interface just mentioned:
--
interface PersonRepository extends RevisionRepository<Person, Long, Integer>, CrudRepository<Person, Long> {
  // Your query methods go here
}

--

Open H2 Console to check audit and revision history data.
