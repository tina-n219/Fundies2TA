interface IFunc<A, R> {
  R apply(A input);
}

// 
interface JSONVisitor<T> extends IFunc<JSON, T> {
	
	T visitJSONBlank(JSONBlank b);
	
	T visitJSONNumber(JSONNumber n);
	
	T visitJSONBool(JSONBool b);
	
	T visitJSONString(JSONString s);
}

// a json value
interface JSON {}
 
// no value
class JSONBlank implements JSON {}
 
// a number
class JSONNumber implements JSON {
  int number;
 
  JSONNumber(int number) {
    this.number = number;
  }
}
 
// a boolean
class JSONBool implements JSON {
  boolean bool;
 
  JSONBool(boolean bool) {
    this.bool = bool;
  }
}
 
// a string
class JSONString implements JSON {
  String str;
 
  JSONString(String str) {
    this.str = str;
  }
}