package br.com.jhegnerlabs.fixturefactory.template;

import br.com.jhegnerlabs.fixturefactory.Aircrew;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class AircrewTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Aircrew.class).addTemplate("random", new Rule(){{
            add("name", firstName());
        }});
    }
}