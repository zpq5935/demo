package mapper;

import domain.Person;

public interface PersonMapper {
	Person selectPersonById(Integer id);
}
