package com.thang.tools.model;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import com.thang.tools.util.StrUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class AddUnderLine implements TemplateDirectiveModel {

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		    if(null!=body){
		        body.render(new AddUnderLineWriter(env.getOut()));
		    }
		
	}

	
	private static class AddUnderLineWriter extends Writer {
		private final Writer out;
		AddUnderLineWriter (Writer out) {
		    this.out = out;
		}
		public void write(char[] cbuf, int off, int len)throws IOException {
			out.write(String.copyValueOf(cbuf, off, len));
		}
		
		@Override
		public void write(String str) throws IOException {
			super.write(StrUtils.addUnderline(str.trim()));
		}
	    
		public void flush() throws IOException {
			out.flush();
		}
		
		public void close() throws IOException {
			out.close();
		}
		
	}
	
}
