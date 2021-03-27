package scom.project.api.repository;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Repository
public interface BaseRepository {
	@Getter
	@Setter
	class QueryObject {
		private String clause;
		private Map<String, Object> parameters;
		
		public QueryObject () {
			clause = "";
			parameters = new HashMap<>();
		}
	}
	
	public Query fillQueryParameters(Query query, Map<String, Object> parameters);
	
	public Query fillQueryPageableAndParameters(Integer page, Integer size, QueryObject whereClause, Query query);
}