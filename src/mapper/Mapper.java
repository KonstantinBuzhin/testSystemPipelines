package mapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import model.Pipeline;
import model.Route;

public class Mapper {

	public List<Route> mapSetter() {
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("idA", "idA");
		mapping.put("idB", "idB");

		HeaderColumnNameTranslateMappingStrategy<Route> strategy = new HeaderColumnNameTranslateMappingStrategy<Route>();
		strategy.setType(Route.class);
		strategy.setColumnMapping(mapping);

		File csvFile = new File("setter.csv").getAbsoluteFile();

		CsvMapper csvMapper = new CsvMapper();

		CsvSchema bootstrapSchema = CsvSchema.builder().addColumn("idA").addColumn("idB").build();
		csvMapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);

		ObjectReader reader = csvMapper.reader(Route.class).with(bootstrapSchema);
		MappingIterator<Route> iterator;
		List<Route> list = new ArrayList<>();
		try {
			iterator = reader.readValues(csvFile);

			iterator.forEachRemaining(list::add);

			for (Route r : list) {

				r.setIdB(r.getIdA().split(";")[1]);
				r.setIdA(r.getIdA().split(";")[0]);

			}
			list.remove(0);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public List<Pipeline> mapDescriber() {
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("idX", "idX");
		mapping.put("idY", "idY");
		mapping.put("length", "length");

		HeaderColumnNameTranslateMappingStrategy<Pipeline> strategy = new HeaderColumnNameTranslateMappingStrategy<Pipeline>();
		strategy.setType(Pipeline.class);
		strategy.setColumnMapping(mapping);

		File csvFile = new File("describer.csv").getAbsoluteFile();

		CsvMapper csvMapper = new CsvMapper();

		CsvSchema bootstrapSchema = CsvSchema.builder().addColumn("idX").addColumn("idY").addColumn("length").build();
		csvMapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);

		ObjectReader reader = csvMapper.reader(Pipeline.class).with(bootstrapSchema);
		MappingIterator<Pipeline> iterator;
		List<Pipeline> list = new ArrayList<>();
		try {
			iterator = reader.readValues(csvFile);

			iterator.forEachRemaining(list::add);

			for (Pipeline p : list) {

				p.setIdY(p.getIdX().split(";")[1]);
				p.setLength(p.getIdX().split(";")[2]);
				p.setIdX(p.getIdX().split(";")[0]);

			}
			list.remove(0);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
