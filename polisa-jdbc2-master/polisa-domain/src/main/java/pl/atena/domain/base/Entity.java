package pl.atena.domain.base;

/**
 * Bazowa klasa
 * 
 * @author michalh
 *
 */
public abstract class Entity {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
