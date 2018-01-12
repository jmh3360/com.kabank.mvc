package com.kabank.mvc.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;


public class ParamsIterator {
	public static Map<?,?> execute(HttpServletRequest request) {
		Map<String, String> result = new HashMap<>();
		Map<String, String[]> map = request.getParameterMap();
		//
		Set<Entry<String, String[]>> set = map.entrySet();
		//while loop로 돌리기 위해 맵에 있는것을 셋에다 옮겨 담는다, 엔트리는 내용물
		Iterator<Map.Entry<String, String[]>> it = set.iterator();
		//이터레이터의 역할은 한번읽은 값을 표시하면서 지나간다.
		//이유는 셋의 값을 확인하려고 하는것인데 셋은 인덱스 값이 없기 때문이다.
		String params[] = new String [set.size()];
		int i = 0;
		while (it.hasNext())/*셋이라 와일loop를 돌린다. */{
			Map.Entry<String, String[]> e =it.next();
			params[i] = e.getKey();
			i++;
		}
		for(i=0;i<params.length;i++) {
			if(map.get(params[i]).length==1)/*밸류값이 하나일때*/{
				result.put(params[i], map.get(params[i])[0]);
			}else {
				String temp="";
				for(int j=0;j<map.get(params[i]).length;j++)/*밸류값이 복수일 때 화면에서 checkbox의 경우*/{
					temp += map.get(params[i])[j]+",";
					}
				//쉼표를 주어서 밸류를 하나값으로 바뀌게 된다.
				//
				result.put(params[i], temp);
			}
		}
		
		return result;
		
	}
}
