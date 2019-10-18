// CS 2510 - LAB 6 Oct. 18, 2019 Tina Noorani

interface IFunc<A, R> {
	R apply(A input);
}

// Interface representing our Visitor, returns type <T>
// Our IFunc<JSON, T> takes in a JSON as an input, it returns a value of type T
interface JSONVisitor<T> extends IFunc<JSON, T> {

	T visitJSONBlank(JSONBlank b);

	T visitJSONNumber(JSONNumber n);

	T visitJSONBool(JSONBool b);

	T visitJSONString(JSONString s);
}

// Let's convert out JSON to a Number
// Since we have a purpose here to return a Number, 
// we will switch out our <T> to an actual value of <Integer> 
// (Note: All the method return types should also be switched to reflect that)
class JSONToNumber implements JSONVisitor<Integer> {

	// STEP 1: implement APPLY()
	// delegate with our JSON object to the respective accept method
	public Integer apply(JSON input) {
		return input.accept(this);
	}

	// STEP 3: implement visitCLASS_NAME() method to perform computations with data from 
	// parameter passed, this is where the bulk of your code should be and main logic
	public Integer visitJSONBlank(JSONBlank b) {
		return 0;
	}

	// STEP 3: implement visitCLASS_NAME() method to perform computations with data from 
	// parameter passed, this is where the bulk of your code should be and main logic
	public Integer visitJSONNumber(JSONNumber n) {
		return n.number;
	}

	// STEP 3: implement visitCLASS_NAME() method to perform computations with data from 
	// parameter passed, this is where the bulk of your code should be and main logic
	public Integer visitJSONBool(JSONBool b) {
		// return b.bool ? 1 : 0;
		if (b.bool) {
			return 1;
		} else {
			return 0;
		}
	}

	// STEP 3: implement visitCLASS_NAME() method to perform computations with data from 
	// parameter passed, this is where the bulk of your code should be and main logic
	public Integer visitJSONString(JSONString s) {
		return s.str.length();
	}

}

// a json value
interface JSON {
	// Our class has no context of generics, thus we must define our generic with `<R>` and then actually specify our 
	// generic return type with R.
	<R> R accept(JSONVisitor<R> visitor);
}

// no value
class JSONBlank implements JSON {
	// STEP 2: implement ACCEPT(Visitor<R>)
	// Now that we are in a specific class, let's delegate to our visit specific method and 
	// pass in our class object so that our visit method has data to work with
	// (Note: consider why we couldn't implement the functionality of our visitClassName() method
	// inside of our apply() method)
	@Override
	public <R> R accept(JSONVisitor<R> visitor) {
		return visitor.visitJSONBlank(this);
	}
}

// a number
class JSONNumber implements JSON {
	int number;

	JSONNumber(int number) {
		this.number = number;
	}

	// STEP 2: implement ACCEPT(Visitor<R>)
	// Now that we are in a specific class, let's delegate to our visit specific method and 
	// pass in our class object so that our visit method has data to work with
	// (Note: consider why we couldn't implement the functionality of our visitClassName() method
	// inside of our apply() method)
	@Override
	public <R> R accept(JSONVisitor<R> visitor) {
		return visitor.visitJSONNumber(this);
	}
}

// a boolean
class JSONBool implements JSON {
	boolean bool;

	JSONBool(boolean bool) {
		this.bool = bool;
	}

	// STEP 2: implement ACCEPT(Visitor<R>)
	// Now that we are in a specific class, let's delegate to our visit specific method and 
	// pass in our class object so that our visit method has data to work with
	// (Note: consider why we couldn't implement the functionality of our visitClassName() method
	// inside of our apply() method)
	@Override
	public <R> R accept(JSONVisitor<R> visitor) {
		return visitor.visitJSONBool(this);
	}
}

// a string
class JSONString implements JSON {
	String str;

	JSONString(String str) {
		this.str = str;
	}

	// STEP 2: implement ACCEPT(Visitor<R>)
	// Now that we are in a specific class, let's delegate to our visit specific method and 
	// pass in our class object so that our visit method has data to work with
	// (Note: consider why we couldn't implement the functionality of our visitClassName() method
	// inside of our apply() method)
	@Override
	public <R> R accept(JSONVisitor<R> visitor) {
		return visitor.visitJSONString(this);
	}
}
