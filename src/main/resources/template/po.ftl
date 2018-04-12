package ${poPackage};

public class ${poClassName} {

  <#list poProperties as prop>
    private ${prop.type} ${prop.name};
  </#list>

  <#list poProperties as prop>
    public ${prop.type} get${prop.name?cap_first}(){
      return ${prop.name};
    }
    public void set${prop.name?cap_first}(${prop.type} ${prop.name}){
      this.${prop.name} = ${prop.name};
    }
  </#list>

}