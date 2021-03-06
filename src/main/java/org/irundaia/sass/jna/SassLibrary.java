/*
 * Copyright 2017 Han van Venrooij
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.irundaia.sass.jna;

import com.sun.jna.*;
import com.sun.jna.ptr.PointerByReference;

import java.nio.ByteBuffer;

public interface SassLibrary extends Library {
	public static final String JNA_LIBRARY_NAME = "sass";
	public static final SassLibrary INSTANCE = (SassLibrary)Native.loadLibrary(SassLibrary.JNA_LIBRARY_NAME, SassLibrary.class);
	/**
	 * Different render styles<br>
	 * <i>native declaration : src/native/include/sass/base.h:43</i><br>
	 * enum values
	 */
	public static interface Sass_Output_Style {
		/** <i>native declaration : src/native/include/sass/base.h:44</i> */
		public static final int SASS_STYLE_NESTED = 0;
		/** <i>native declaration : src/native/include/sass/base.h:45</i> */
		public static final int SASS_STYLE_EXPANDED = 1;
		/** <i>native declaration : src/native/include/sass/base.h:46</i> */
		public static final int SASS_STYLE_COMPACT = 2;
		/** <i>native declaration : src/native/include/sass/base.h:47</i> */
		public static final int SASS_STYLE_COMPRESSED = 3;
		/** <i>native declaration : src/native/include/sass/base.h:49</i> */
		public static final int SASS_STYLE_INSPECT = 4;
		/** <i>native declaration : src/native/include/sass/base.h:50</i> */
		public static final int SASS_STYLE_TO_SASS = 5;
	};
	/**
	 * Type for Sass values<br>
	 * <i>native declaration : src/native/include/sass/values.h:11</i><br>
	 * enum values
	 */
	public static interface Sass_Tag {
		/** <i>native declaration : src/native/include/sass/values.h:12</i> */
		public static final int SASS_BOOLEAN = 0;
		/** <i>native declaration : src/native/include/sass/values.h:13</i> */
		public static final int SASS_NUMBER = 1;
		/** <i>native declaration : src/native/include/sass/values.h:14</i> */
		public static final int SASS_COLOR = 2;
		/** <i>native declaration : src/native/include/sass/values.h:15</i> */
		public static final int SASS_STRING = 3;
		/** <i>native declaration : src/native/include/sass/values.h:16</i> */
		public static final int SASS_LIST = 4;
		/** <i>native declaration : src/native/include/sass/values.h:17</i> */
		public static final int SASS_MAP = 5;
		/** <i>native declaration : src/native/include/sass/values.h:18</i> */
		public static final int SASS_NULL = 6;
		/** <i>native declaration : src/native/include/sass/values.h:19</i> */
		public static final int SASS_ERROR = 7;
		/** <i>native declaration : src/native/include/sass/values.h:20</i> */
		public static final int SASS_WARNING = 8;
	};
	/**
	 * Tags for denoting Sass list separators<br>
	 * <i>native declaration : src/native/include/sass/values.h:24</i><br>
	 * enum values
	 */
	public static interface Sass_Separator {
		/** <i>native declaration : src/native/include/sass/values.h:25</i> */
		public static final int SASS_COMMA = 0;
		/** <i>native declaration : src/native/include/sass/values.h:26</i> */
		public static final int SASS_SPACE = 1;
		/** <i>native declaration : src/native/include/sass/values.h:29</i> */
		public static final int SASS_HASH = 2;
	};
	/**
	 * Value Operators<br>
	 * <i>native declaration : src/native/include/sass/values.h:33</i><br>
	 * enum values
	 */
	public static interface Sass_OP {
		/**
		 * logical connectives<br>
		 * <i>native declaration : src/native/include/sass/values.h:34</i>
		 */
		public static final int AND = 0;
		/**
		 * logical connectives<br>
		 * <i>native declaration : src/native/include/sass/values.h:34</i>
		 */
		public static final int OR = 1;
		/**
		 * arithmetic relations<br>
		 * <i>native declaration : src/native/include/sass/values.h:35</i>
		 */
		public static final int EQ = 2;
		/**
		 * arithmetic relations<br>
		 * <i>native declaration : src/native/include/sass/values.h:35</i>
		 */
		public static final int NEQ = 3;
		/**
		 * arithmetic relations<br>
		 * <i>native declaration : src/native/include/sass/values.h:35</i>
		 */
		public static final int GT = 4;
		/**
		 * arithmetic relations<br>
		 * <i>native declaration : src/native/include/sass/values.h:35</i>
		 */
		public static final int GTE = 5;
		/**
		 * arithmetic relations<br>
		 * <i>native declaration : src/native/include/sass/values.h:35</i>
		 */
		public static final int LT = 6;
		/**
		 * arithmetic relations<br>
		 * <i>native declaration : src/native/include/sass/values.h:35</i>
		 */
		public static final int LTE = 7;
		/**
		 * arithmetic functions<br>
		 * <i>native declaration : src/native/include/sass/values.h:36</i>
		 */
		public static final int ADD = 8;
		/**
		 * arithmetic functions<br>
		 * <i>native declaration : src/native/include/sass/values.h:36</i>
		 */
		public static final int SUB = 9;
		/**
		 * arithmetic functions<br>
		 * <i>native declaration : src/native/include/sass/values.h:36</i>
		 */
		public static final int MUL = 10;
		/**
		 * arithmetic functions<br>
		 * <i>native declaration : src/native/include/sass/values.h:36</i>
		 */
		public static final int DIV = 11;
		/**
		 * arithmetic functions<br>
		 * <i>native declaration : src/native/include/sass/values.h:36</i>
		 */
		public static final int MOD = 12;
		/**
		 * so we know how big to make the op table<br>
		 * <i>native declaration : src/native/include/sass/values.h:37</i>
		 */
		public static final int NUM_OPS = 13;
	};
	/**
	 * Compiler states<br>
	 * <i>native declaration : src/native/include/sass/context.h:24</i><br>
	 * enum values
	 */
	public static interface Sass_Compiler_State {
		/** <i>native declaration : src/native/include/sass/context.h:25</i> */
		public static final int SASS_COMPILER_CREATED = 0;
		/** <i>native declaration : src/native/include/sass/context.h:26</i> */
		public static final int SASS_COMPILER_PARSED = 1;
		/** <i>native declaration : src/native/include/sass/context.h:27</i> */
		public static final int SASS_COMPILER_EXECUTED = 2;
	};
	/** <i>native declaration : src/native/include/sass/functions.h</i> */
	public interface Sass_Importer_Fn extends Callback {
		SassLibrary.Sass_Import_List apply(Pointer url, Pointer cb, SassLibrary.Sass_Compiler compiler);
	};
	/** <i>native declaration : src/native/include/sass/functions.h</i> */
	public interface Sass_Function_Fn extends Callback {
		SassLibrary.Sass_Value apply(SassLibrary.Sass_Value Sass_ValuePtr1, Pointer cb, SassLibrary.Sass_Compiler compiler);
	};
	/**
	 * Hardcoded version 3.4 for time being<br>
	 * Original signature : <code>char* libsass_version()</code><br>
	 * <i>native declaration : src/native/include/sass/base.h:69</i>
	 */
	String libsass_version();
	/**
	 * Get compiled libsass language<br>
	 * Original signature : <code>char* libsass_language_version()</code><br>
	 * <i>native declaration : src/native/include/sass/base.h:72</i>
	 */
	String libsass_language_version();
	/**
	 * Creator functions for all value types<br>
	 * Original signature : <code>Sass_Value* sass_make_null()</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:41</i>
	 */
	SassLibrary.Sass_Value sass_make_null();
	/**
	 * Original signature : <code>Sass_Value* sass_make_boolean(bool)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:42</i>
	 */
	SassLibrary.Sass_Value sass_make_boolean(boolean val);
	/**
	 * Original signature : <code>Sass_Value* sass_make_string(const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:43</i>
	 */
	SassLibrary.Sass_Value sass_make_string(String val);
	/**
	 * Original signature : <code>Sass_Value* sass_make_qstring(const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:44</i>
	 */
	SassLibrary.Sass_Value sass_make_qstring(String val);
	/**
	 * Original signature : <code>Sass_Value* sass_make_number(double, const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:45</i>
	 */
	SassLibrary.Sass_Value sass_make_number(double val, String unit);
	/**
	 * Original signature : <code>Sass_Value* sass_make_color(double, double, double, double)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:46</i>
	 */
	SassLibrary.Sass_Value sass_make_color(double r, double g, double b, double a);
	/**
	 * Original signature : <code>Sass_Value* sass_make_list(size_t, Sass_Separator)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:47</i>
	 */
	SassLibrary.Sass_Value sass_make_list(SizeT len, int sep);
	/**
	 * Original signature : <code>Sass_Value* sass_make_map(size_t)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:48</i>
	 */
	SassLibrary.Sass_Value sass_make_map(SizeT len);
	/**
	 * Original signature : <code>Sass_Value* sass_make_error(const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:49</i>
	 */
	SassLibrary.Sass_Value sass_make_error(String msg);
	/**
	 * Original signature : <code>Sass_Value* sass_make_warning(const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:50</i>
	 */
	SassLibrary.Sass_Value sass_make_warning(String msg);
	/**
	 * Execute an operation for two Sass_Values and return the result as a Sass_Value too<br>
	 * Original signature : <code>Sass_Value* sass_value_op(Sass_OP, Sass_Value*, Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:61</i>
	 */
	SassLibrary.Sass_Value sass_value_op(int op, SassLibrary.Sass_Value a, SassLibrary.Sass_Value b);
	/**
	 * Stringify a Sass_Values and also return the result as a Sass_Value (of type STRING)<br>
	 * Original signature : <code>Sass_Value* sass_value_stringify(Sass_Value*, bool, int)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:64</i>
	 */
	SassLibrary.Sass_Value sass_value_stringify(SassLibrary.Sass_Value a, byte compressed, int precision);
	/**
	 * Check is needed before accessing specific values!<br>
	 * Original signature : <code>Sass_Tag sass_value_get_tag(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:68</i>
	 */
	int sass_value_get_tag(SassLibrary.Sass_Value v);
	/**
	 * Can also be used before accessing properties!<br>
	 * Original signature : <code>bool sass_value_is_null(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:72</i>
	 */
	boolean sass_value_is_null(SassLibrary.Sass_Value v);
	/**
	 * Original signature : <code>bool sass_value_is_number(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:73</i>
	 */
	boolean sass_value_is_number(SassLibrary.Sass_Value v);
	/**
	 * Original signature : <code>bool sass_value_is_string(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:74</i>
	 */
	boolean sass_value_is_string(SassLibrary.Sass_Value v);
	/**
	 * Original signature : <code>bool sass_value_is_boolean(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:75</i>
	 */
	boolean sass_value_is_boolean(SassLibrary.Sass_Value v);
	/**
	 * Original signature : <code>bool sass_value_is_color(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:76</i>
	 */
	boolean sass_value_is_color(SassLibrary.Sass_Value v);
	/**
	 * Original signature : <code>bool sass_value_is_list(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:77</i>
	 */
	boolean sass_value_is_list(SassLibrary.Sass_Value v);
	/**
	 * Original signature : <code>bool sass_value_is_map(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:78</i>
	 */
	boolean sass_value_is_map(SassLibrary.Sass_Value v);
	/**
	 * Original signature : <code>bool sass_value_is_error(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:79</i>
	 */
	boolean sass_value_is_error(SassLibrary.Sass_Value v);
	/**
	 * Original signature : <code>bool sass_value_is_warning(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:80</i>
	 */
	boolean sass_value_is_warning(SassLibrary.Sass_Value v);
	/**
	 * Getters and setters for Sass_Number<br>
	 * Original signature : <code>double sass_number_get_value(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:83</i>
	 */
	double sass_number_get_value(SassLibrary.Sass_Value v);
	/**
	 * Original signature : <code>void sass_number_set_value(Sass_Value*, double)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:84</i>
	 */
	void sass_number_set_value(SassLibrary.Sass_Value v, double value);
	/**
	 * Original signature : <code>char* sass_number_get_unit(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:85</i>
	 */
	String sass_number_get_unit(SassLibrary.Sass_Value v);
	/**
	 * Getters and setters for Sass_String<br>
	 * Original signature : <code>char* sass_string_get_value(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:89</i>
	 */
	String sass_string_get_value(SassLibrary.Sass_Value v);
	/**
	 * Getters and setters for Sass_Boolean<br>
	 * Original signature : <code>bool sass_boolean_get_value(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:95</i>
	 */
	boolean sass_boolean_get_value(SassLibrary.Sass_Value v);
	/**
	 * Getters and setters for Sass_Color<br>
	 * Original signature : <code>double sass_color_get_r(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:99</i>
	 */
	double sass_color_get_r(SassLibrary.Sass_Value v);
	/**
	 * Original signature : <code>double sass_color_get_g(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:101</i>
	 */
	double sass_color_get_g(SassLibrary.Sass_Value v);
	/**
	 * Original signature : <code>double sass_color_get_b(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:103</i>
	 */
	double sass_color_get_b(SassLibrary.Sass_Value v);
	/**
	 * Original signature : <code>double sass_color_get_a(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:105</i>
	 */
	double sass_color_get_a(SassLibrary.Sass_Value v);
	/**
	 * Getter for the number of items in list<br>
	 * Original signature : <code>size_t sass_list_get_length(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:109</i>
	 */
	SizeT sass_list_get_length(SassLibrary.Sass_Value v);
	/**
	 * Getters and setters for Sass_List<br>
	 * Original signature : <code>Sass_Separator sass_list_get_separator(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:111</i>
	 */
	int sass_list_get_separator(SassLibrary.Sass_Value v);
	/**
	 * Getters and setters for Sass_List values<br>
	 * Original signature : <code>Sass_Value* sass_list_get_value(Sass_Value*, size_t)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:114</i>
	 */
	SassLibrary.Sass_Value sass_list_get_value(SassLibrary.Sass_Value v, SizeT i);
	/**
	 * Original signature : <code>void sass_list_set_value(Sass_Value*, size_t, Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:115</i>
	 */
	void sass_list_set_value(SassLibrary.Sass_Value v, SizeT i, SassLibrary.Sass_Value value);
	/**
	 * Getter for the number of items in map<br>
	 * Original signature : <code>size_t sass_map_get_length(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:118</i>
	 */
	SizeT sass_map_get_length(SassLibrary.Sass_Value v);
	/**
	 * Getters and setters for Sass_Map keys and values<br>
	 * Original signature : <code>Sass_Value* sass_map_get_key(Sass_Value*, size_t)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:120</i>
	 */
	SassLibrary.Sass_Value sass_map_get_key(SassLibrary.Sass_Value v, SizeT i);
	/**
	 * Original signature : <code>void sass_map_set_key(Sass_Value*, size_t, Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:121</i>
	 */
	void sass_map_set_key(SassLibrary.Sass_Value v, SizeT i, SassLibrary.Sass_Value Sass_ValuePtr1);
	/**
	 * Original signature : <code>Sass_Value* sass_map_get_value(Sass_Value*, size_t)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:122</i>
	 */
	SassLibrary.Sass_Value sass_map_get_value(SassLibrary.Sass_Value v, SizeT i);
	/**
	 * Original signature : <code>void sass_map_set_value(Sass_Value*, size_t, Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:123</i>
	 */
	void sass_map_set_value(SassLibrary.Sass_Value v, SizeT i, SassLibrary.Sass_Value Sass_ValuePtr1);
	/**
	 * Getters and setters for Sass_Error<br>
	 * Original signature : <code>char* sass_error_get_message(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:126</i>
	 */
	Pointer sass_error_get_message(SassLibrary.Sass_Value v);
	/**
	 * Getters and setters for Sass_Warning<br>
	 * Original signature : <code>char* sass_warning_get_message(Sass_Value*)</code><br>
	 * <i>native declaration : src/native/include/sass/values.h:130</i>
	 */
	Pointer sass_warning_get_message(SassLibrary.Sass_Value v);
	/**
	 * Creator for sass custom importer return argument list<br>
	 * Original signature : <code>Sass_Importer_List sass_make_importer_list(size_t)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:33</i>
	 */
	SassLibrary.Sass_Importer_List sass_make_importer_list(SizeT length);
	/**
	 * Original signature : <code>Sass_Importer_Entry sass_importer_get_list_entry(Sass_Importer_List, size_t)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:34</i>
	 */
	SassLibrary.Sass_Importer_Entry sass_importer_get_list_entry(SassLibrary.Sass_Importer_List list, SizeT idx);
	/**
	 * Original signature : <code>void sass_importer_set_list_entry(Sass_Importer_List, size_t, Sass_Importer_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:35</i>
	 */
	void sass_importer_set_list_entry(SassLibrary.Sass_Importer_List list, SizeT idx, SassLibrary.Sass_Importer_Entry entry);
	/**
	 * The pointer is mostly used to store the callback into the actual binding<br>
	 * Original signature : <code>Sass_Importer_Entry sass_make_importer(Sass_Importer_Fn, double, void*)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:40</i>
	 */
	SassLibrary.Sass_Importer_Entry sass_make_importer(SassLibrary.Sass_Importer_Fn importer, double priority, Pointer cookie);
	/**
	 * Getters for import function descriptors<br>
	 * Original signature : <code>Sass_Importer_Fn sass_importer_get_function(Sass_Importer_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:43</i>
	 */
	SassLibrary.Sass_Importer_Fn sass_importer_get_function(SassLibrary.Sass_Importer_Entry cb);
	/**
	 * Original signature : <code>double sass_importer_get_priority(Sass_Importer_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:44</i>
	 */
	double sass_importer_get_priority(SassLibrary.Sass_Importer_Entry cb);
	/**
	 * Original signature : <code>void* sass_importer_get_cookie(Sass_Importer_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:45</i>
	 */
	Pointer sass_importer_get_cookie(SassLibrary.Sass_Importer_Entry cb);
	/**
	 * Deallocator for associated memory<br>
	 * Original signature : <code>void sass_delete_importer(Sass_Importer_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:48</i>
	 */
	void sass_delete_importer(SassLibrary.Sass_Importer_Entry cb);
	/**
	 * Creator for sass custom importer return argument list<br>
	 * Original signature : <code>Sass_Import_List sass_make_import_list(size_t)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:51</i>
	 */
	SassLibrary.Sass_Import_List sass_make_import_list(SizeT length);
	/**
	 * Creator for a single import entry returned by the custom importer inside the list<br>
	 * Original signature : <code>Sass_Import_Entry sass_make_import_entry(const char*, char*, char*)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:53</i>
	 */
	SassLibrary.Sass_Import_Entry sass_make_import_entry(String path, ByteBuffer source, ByteBuffer srcmap);
	/**
	 * Original signature : <code>Sass_Import_Entry sass_make_import(const char*, const char*, char*, char*)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:54</i>
	 */
	SassLibrary.Sass_Import_Entry sass_make_import(String imp_path, String abs_base, ByteBuffer source, ByteBuffer srcmap);
	/**
	 * set error message to abort import and to print out a message (path from existing object is used in output)<br>
	 * Original signature : <code>Sass_Import_Entry sass_import_set_error(Sass_Import_Entry, const char*, size_t, size_t)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:56</i>
	 */
	SassLibrary.Sass_Import_Entry sass_import_set_error(SassLibrary.Sass_Import_Entry import$, String message, SizeT line, SizeT col);
	/**
	 * Since we are dealing with pointers they should have a guaranteed and fixed size<br>
	 * Original signature : <code>void sass_import_set_list_entry(Sass_Import_List, size_t, Sass_Import_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:60</i>
	 */
	void sass_import_set_list_entry(SassLibrary.Sass_Import_List list, SizeT idx, SassLibrary.Sass_Import_Entry entry);
	/**
	 * Original signature : <code>Sass_Import_Entry sass_import_get_list_entry(Sass_Import_List, size_t)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:61</i>
	 */
	SassLibrary.Sass_Import_Entry sass_import_get_list_entry(SassLibrary.Sass_Import_List list, SizeT idx);
	/**
	 * Getters for import entry<br>
	 * Original signature : <code>char* sass_import_get_imp_path(Sass_Import_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:64</i>
	 */
	String sass_import_get_imp_path(SassLibrary.Sass_Import_Entry Sass_Import_Entry1);
	/**
	 * Original signature : <code>char* sass_import_get_abs_path(Sass_Import_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:65</i>
	 */
	String sass_import_get_abs_path(SassLibrary.Sass_Import_Entry Sass_Import_Entry1);
	/**
	 * Original signature : <code>char* sass_import_get_source(Sass_Import_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:66</i>
	 */
	String sass_import_get_source(SassLibrary.Sass_Import_Entry Sass_Import_Entry1);
	/**
	 * Original signature : <code>char* sass_import_get_srcmap(Sass_Import_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:67</i>
	 */
	String sass_import_get_srcmap(SassLibrary.Sass_Import_Entry Sass_Import_Entry1);
	/**
	 * The property on our struct will be reset to NULL<br>
	 * Original signature : <code>char* sass_import_take_source(Sass_Import_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:70</i>
	 */
	Pointer sass_import_take_source(SassLibrary.Sass_Import_Entry Sass_Import_Entry1);
	/**
	 * Original signature : <code>char* sass_import_take_srcmap(Sass_Import_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:71</i>
	 */
	Pointer sass_import_take_srcmap(SassLibrary.Sass_Import_Entry Sass_Import_Entry1);
	/**
	 * Getters from import error entry<br>
	 * Original signature : <code>size_t sass_import_get_error_line(Sass_Import_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:73</i>
	 */
	SizeT sass_import_get_error_line(SassLibrary.Sass_Import_Entry Sass_Import_Entry1);
	/**
	 * Original signature : <code>size_t sass_import_get_error_column(Sass_Import_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:74</i>
	 */
	SizeT sass_import_get_error_column(SassLibrary.Sass_Import_Entry Sass_Import_Entry1);
	/**
	 * Original signature : <code>char* sass_import_get_error_message(Sass_Import_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:75</i>
	 */
	String sass_import_get_error_message(SassLibrary.Sass_Import_Entry Sass_Import_Entry1);
	/**
	 * Deallocator for associated memory (incl. entries)<br>
	 * Original signature : <code>void sass_delete_import_list(Sass_Import_List)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:78</i>
	 */
	void sass_delete_import_list(SassLibrary.Sass_Import_List Sass_Import_List1);
	/**
	 * Just in case we have some stray import structs<br>
	 * Original signature : <code>void sass_delete_import(Sass_Import_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:80</i>
	 */
	void sass_delete_import(SassLibrary.Sass_Import_Entry Sass_Import_Entry1);
	/**
	 * Creators for sass function list and function descriptors<br>
	 * Original signature : <code>Sass_Function_List sass_make_function_list(size_t)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:85</i>
	 */
	SassLibrary.Sass_Function_List sass_make_function_list(SizeT length);
	/**
	 * Original signature : <code>Sass_Function_Entry sass_make_function(const char*, Sass_Function_Fn, void*)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:86</i>
	 */
	SassLibrary.Sass_Function_Entry sass_make_function(String signature, SassLibrary.Sass_Function_Fn cb, Pointer cookie);
	/**
	 * Setters and getters for callbacks on function lists<br>
	 * Original signature : <code>Sass_Function_Entry sass_function_get_list_entry(Sass_Function_List, size_t)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:89</i>
	 */
	SassLibrary.Sass_Function_Entry sass_function_get_list_entry(SassLibrary.Sass_Function_List list, SizeT pos);
	/**
	 * Original signature : <code>void sass_function_set_list_entry(Sass_Function_List, size_t, Sass_Function_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:90</i>
	 */
	void sass_function_set_list_entry(SassLibrary.Sass_Function_List list, SizeT pos, SassLibrary.Sass_Function_Entry cb);
	/**
	 * Getters for custom function descriptors<br>
	 * Original signature : <code>char* sass_function_get_signature(Sass_Function_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:93</i>
	 */
	String sass_function_get_signature(SassLibrary.Sass_Function_Entry cb);
	/**
	 * Original signature : <code>Sass_Function_Fn sass_function_get_function(Sass_Function_Entry)</code><br>
	 * <i>native declaration : src/native/include/sass/functions.h:94</i>
	 */
	SassLibrary.Sass_Function_Fn sass_function_get_function(SassLibrary.Sass_Function_Entry cb);
	/**
	 * Create and initialize a specific context<br>
	 * Original signature : <code>Sass_File_Context* sass_make_file_context(const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:33</i>
	 */
	SassLibrary.Sass_File_Context sass_make_file_context(String input_path);
	/**
	 * Original signature : <code>Sass_Data_Context* sass_make_data_context(char*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:34</i>
	 */
	SassLibrary.Sass_Data_Context sass_make_data_context(ByteBuffer source_string);
	/**
	 * Call the compilation step for the specific context<br>
	 * Original signature : <code>int sass_compile_file_context(Sass_File_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:37</i>
	 */
	int sass_compile_file_context(SassLibrary.Sass_File_Context ctx);
	/**
	 * Original signature : <code>int sass_compile_data_context(Sass_Data_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:38</i>
	 */
	int sass_compile_data_context(SassLibrary.Sass_Data_Context ctx);
	/**
	 * Create a sass compiler instance for more control<br>
	 * Original signature : <code>Sass_Compiler* sass_make_file_compiler(Sass_File_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:41</i>
	 */
	SassLibrary.Sass_Compiler sass_make_file_compiler(SassLibrary.Sass_File_Context file_ctx);
	/**
	 * Original signature : <code>Sass_Compiler* sass_make_data_compiler(Sass_Data_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:42</i>
	 */
	SassLibrary.Sass_Compiler sass_make_data_compiler(SassLibrary.Sass_Data_Context data_ctx);
	/**
	 * Usefull if you only want to query the included files<br>
	 * Original signature : <code>int sass_compiler_parse(Sass_Compiler*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:46</i>
	 */
	int sass_compiler_parse(SassLibrary.Sass_Compiler compiler);
	/**
	 * Original signature : <code>int sass_compiler_execute(Sass_Compiler*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:47</i>
	 */
	int sass_compiler_execute(SassLibrary.Sass_Compiler compiler);
	/**
	 * This does _not_ include any contexts or options<br>
	 * Original signature : <code>void sass_delete_compiler(Sass_Compiler*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:51</i>
	 */
	void sass_delete_compiler(SassLibrary.Sass_Compiler compiler);
	/**
	 * Release all memory allocated and also ourself<br>
	 * Original signature : <code>void sass_delete_file_context(Sass_File_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:54</i>
	 */
	void sass_delete_file_context(SassLibrary.Sass_File_Context ctx);
	/**
	 * Original signature : <code>void sass_delete_data_context(Sass_Data_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:55</i>
	 */
	void sass_delete_data_context(SassLibrary.Sass_Data_Context ctx);
	/**
	 * Getters for context from specific implementation<br>
	 * Original signature : <code>Sass_Context* sass_file_context_get_context(Sass_File_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:58</i>
	 */
	SassLibrary.Sass_Context sass_file_context_get_context(SassLibrary.Sass_File_Context file_ctx);
	/**
	 * Original signature : <code>Sass_Context* sass_data_context_get_context(Sass_Data_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:59</i>
	 */
	SassLibrary.Sass_Context sass_data_context_get_context(SassLibrary.Sass_Data_Context data_ctx);
	/**
	 * Getters for Context_Options from Sass_Context<br>
	 * Original signature : <code>Sass_Options* sass_context_get_options(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:62</i>
	 */
	SassLibrary.Sass_Options sass_context_get_options(SassLibrary.Sass_Context ctx);
	/**
	 * Original signature : <code>Sass_Options* sass_file_context_get_options(Sass_File_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:63</i>
	 */
	SassLibrary.Sass_Options sass_file_context_get_options(SassLibrary.Sass_File_Context file_ctx);
	/**
	 * Original signature : <code>Sass_Options* sass_data_context_get_options(Sass_Data_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:64</i>
	 */
	SassLibrary.Sass_Options sass_data_context_get_options(SassLibrary.Sass_Data_Context data_ctx);
	/**
	 * Original signature : <code>void sass_file_context_set_options(Sass_File_Context*, Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:65</i>
	 */
	void sass_file_context_set_options(SassLibrary.Sass_File_Context file_ctx, SassLibrary.Sass_Options opt);
	/**
	 * Original signature : <code>void sass_data_context_set_options(Sass_Data_Context*, Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:66</i>
	 */
	void sass_data_context_set_options(SassLibrary.Sass_Data_Context data_ctx, SassLibrary.Sass_Options opt);
	/**
	 * Getters for Context_Option values<br>
	 * Original signature : <code>int sass_option_get_precision(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:70</i>
	 */
	int sass_option_get_precision(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>Sass_Output_Style sass_option_get_output_style(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:71</i>
	 */
	int sass_option_get_output_style(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>bool sass_option_get_source_comments(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:72</i>
	 */
	boolean sass_option_get_source_comments(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>bool sass_option_get_source_map_embed(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:73</i>
	 */
	boolean sass_option_get_source_map_embed(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>bool sass_option_get_source_map_contents(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:74</i>
	 */
	boolean sass_option_get_source_map_contents(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>bool sass_option_get_omit_source_map_url(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:75</i>
	 */
	boolean sass_option_get_omit_source_map_url(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>bool sass_option_get_is_indented_syntax_src(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:76</i>
	 */
	boolean sass_option_get_is_indented_syntax_src(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>char* sass_option_get_indent(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:77</i>
	 */
	String sass_option_get_indent(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>char* sass_option_get_linefeed(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:78</i>
	 */
	String sass_option_get_linefeed(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>char* sass_option_get_input_path(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:79</i>
	 */
	String sass_option_get_input_path(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>char* sass_option_get_output_path(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:80</i>
	 */
	String sass_option_get_output_path(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>char* sass_option_get_plugin_path(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:81</i>
	 */
	String sass_option_get_plugin_path(SassLibrary.Sass_Options options);

	SizeT sass_option_get_include_path_size(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>char* sass_option_get_include_path(Sass_Options*, size_t)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:82</i>
	 */
	String sass_option_get_include_path(SassLibrary.Sass_Options options, SizeT size);
	/**
	 * Original signature : <code>char* sass_option_get_source_map_file(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:83</i>
	 */
	String sass_option_get_source_map_file(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>char* sass_option_get_source_map_root(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:84</i>
	 */
	String sass_option_get_source_map_root(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>Sass_Importer_List sass_option_get_c_headers(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:85</i>
	 */
	SassLibrary.Sass_Importer_List sass_option_get_c_headers(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>Sass_Importer_List sass_option_get_c_importers(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:86</i>
	 */
	SassLibrary.Sass_Importer_List sass_option_get_c_importers(SassLibrary.Sass_Options options);
	/**
	 * Original signature : <code>Sass_Function_List sass_option_get_c_functions(Sass_Options*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:87</i>
	 */
	SassLibrary.Sass_Function_List sass_option_get_c_functions(SassLibrary.Sass_Options options);
	/**
	 * Setters for Context_Option values<br>
	 * Original signature : <code>void sass_option_set_precision(Sass_Options*, int)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:90</i>
	 */
	void sass_option_set_precision(SassLibrary.Sass_Options options, int precision);
	/**
	 * Original signature : <code>void sass_option_set_output_style(Sass_Options*, Sass_Output_Style)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:91</i>
	 */
	void sass_option_set_output_style(SassLibrary.Sass_Options options, int output_style);
	/**
	 * Original signature : <code>void sass_option_set_source_comments(Sass_Options*, bool)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:92</i>
	 */
	void sass_option_set_source_comments(SassLibrary.Sass_Options options, boolean source_comments);
	/**
	 * Original signature : <code>void sass_option_set_source_map_embed(Sass_Options*, bool)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:93</i>
	 */
	void sass_option_set_source_map_embed(SassLibrary.Sass_Options options, boolean source_map_embed);
	/**
	 * Original signature : <code>void sass_option_set_source_map_contents(Sass_Options*, bool)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:94</i>
	 */
	void sass_option_set_source_map_contents(SassLibrary.Sass_Options options, boolean source_map_contents);
	/**
	 * Original signature : <code>void sass_option_set_omit_source_map_url(Sass_Options*, bool)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:95</i>
	 */
	void sass_option_set_omit_source_map_url(SassLibrary.Sass_Options options, boolean omit_source_map_url);
	/**
	 * Original signature : <code>void sass_option_set_is_indented_syntax_src(Sass_Options*, bool)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:96</i>
	 */
	void sass_option_set_is_indented_syntax_src(SassLibrary.Sass_Options options, boolean is_indented_syntax_src);
	/**
	 * Original signature : <code>void sass_option_set_indent(Sass_Options*, const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:97</i>
	 */
	void sass_option_set_indent(SassLibrary.Sass_Options options, String indent);
	/**
	 * Original signature : <code>void sass_option_set_linefeed(Sass_Options*, const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:98</i>
	 */
	void sass_option_set_linefeed(SassLibrary.Sass_Options options, String linefeed);
	/**
	 * Original signature : <code>void sass_option_set_input_path(Sass_Options*, const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:99</i>
	 */
	void sass_option_set_input_path(SassLibrary.Sass_Options options, String input_path);
	/**
	 * Original signature : <code>void sass_option_set_output_path(Sass_Options*, const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:100</i>
	 */
	void sass_option_set_output_path(SassLibrary.Sass_Options options, String output_path);
	/**
	 * Original signature : <code>void sass_option_set_plugin_path(Sass_Options*, const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:101</i>
	 */
	void sass_option_set_plugin_path(SassLibrary.Sass_Options options, String plugin_path);
	/**
	 * Original signature : <code>void sass_option_set_include_path(Sass_Options*, const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:102</i>
	 */
	void sass_option_set_include_path(SassLibrary.Sass_Options options, String include_path);
	/**
	 * Original signature : <code>void sass_option_set_source_map_file(Sass_Options*, const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:103</i>
	 */
	void sass_option_set_source_map_file(SassLibrary.Sass_Options options, String source_map_file);
	/**
	 * Original signature : <code>void sass_option_set_source_map_root(Sass_Options*, const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:104</i>
	 */
	void sass_option_set_source_map_root(SassLibrary.Sass_Options options, String source_map_root);
	/**
	 * Original signature : <code>void sass_option_set_c_headers(Sass_Options*, Sass_Importer_List)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:105</i>
	 */
	void sass_option_set_c_headers(SassLibrary.Sass_Options options, SassLibrary.Sass_Importer_List c_headers);
	/**
	 * Original signature : <code>void sass_option_set_c_importers(Sass_Options*, Sass_Importer_List)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:106</i>
	 */
	void sass_option_set_c_importers(SassLibrary.Sass_Options options, SassLibrary.Sass_Importer_List c_importers);
	/**
	 * Original signature : <code>void sass_option_set_c_functions(Sass_Options*, Sass_Function_List)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:107</i>
	 */
	void sass_option_set_c_functions(SassLibrary.Sass_Options options, SassLibrary.Sass_Function_List c_functions);
	/**
	 * Getters for Sass_Context values<br>
	 * Original signature : <code>char* sass_context_get_output_string(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:111</i>
	 */
	String sass_context_get_output_string(SassLibrary.Sass_Context ctx);
	/**
	 * Original signature : <code>int sass_context_get_error_status(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:112</i>
	 */
	int sass_context_get_error_status(SassLibrary.Sass_Context ctx);
	/**
	 * Original signature : <code>char* sass_context_get_error_json(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:113</i>
	 */
	String sass_context_get_error_json(SassLibrary.Sass_Context ctx);
	/**
	 * Original signature : <code>char* sass_context_get_error_text(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:114</i>
	 */
	String sass_context_get_error_text(SassLibrary.Sass_Context ctx);
	/**
	 * Original signature : <code>char* sass_context_get_error_message(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:115</i>
	 */
	String sass_context_get_error_message(SassLibrary.Sass_Context ctx);
	/**
	 * Original signature : <code>char* sass_context_get_error_file(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:116</i>
	 */
	String sass_context_get_error_file(SassLibrary.Sass_Context ctx);
	/**
	 * Original signature : <code>char* sass_context_get_error_src(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:117</i>
	 */
	String sass_context_get_error_src(SassLibrary.Sass_Context ctx);
	/**
	 * Original signature : <code>size_t sass_context_get_error_line(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:118</i>
	 */
	SizeT sass_context_get_error_line(SassLibrary.Sass_Context ctx);
	/**
	 * Original signature : <code>size_t sass_context_get_error_column(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:119</i>
	 */
	SizeT sass_context_get_error_column(SassLibrary.Sass_Context ctx);
	/**
	 * Original signature : <code>char* sass_context_get_source_map_string(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:120</i>
	 */
	String sass_context_get_source_map_string(SassLibrary.Sass_Context ctx);
	/**
	 * Original signature : <code>char** sass_context_get_included_files(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:121</i>
	 */
	String[] sass_context_get_included_files(SassLibrary.Sass_Context ctx);
	/**
	 * Calculate the size of the stored null terminated array<br>
	 * Original signature : <code>size_t sass_context_get_included_files_size(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:124</i>
	 */
	SizeT sass_context_get_included_files_size(SassLibrary.Sass_Context ctx);
	/**
	 * Original signature : <code>char** sass_context_take_included_files(Sass_Context*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:133</i>
	 */
	PointerByReference sass_context_take_included_files(SassLibrary.Sass_Context ctx);
	/**
	 * Getters for Sass_Compiler options<br>
	 * Original signature : <code>Sass_Compiler_State sass_compiler_get_state(Sass_Compiler*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:136</i>
	 */
	int sass_compiler_get_state(SassLibrary.Sass_Compiler compiler);
	/**
	 * Original signature : <code>Sass_Context* sass_compiler_get_context(Sass_Compiler*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:137</i>
	 */
	SassLibrary.Sass_Context sass_compiler_get_context(SassLibrary.Sass_Compiler compiler);
	/**
	 * Original signature : <code>Sass_Options* sass_compiler_get_options(Sass_Compiler*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:138</i>
	 */
	SassLibrary.Sass_Options sass_compiler_get_options(SassLibrary.Sass_Compiler compiler);
	/**
	 * Original signature : <code>size_t sass_compiler_get_import_stack_size(Sass_Compiler*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:139</i>
	 */
	SizeT sass_compiler_get_import_stack_size(SassLibrary.Sass_Compiler compiler);
	/**
	 * Original signature : <code>Sass_Import_Entry sass_compiler_get_last_import(Sass_Compiler*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:140</i>
	 */
	SassLibrary.Sass_Import_Entry sass_compiler_get_last_import(SassLibrary.Sass_Compiler compiler);
	/**
	 * Original signature : <code>Sass_Import_Entry sass_compiler_get_import_entry(Sass_Compiler*, size_t)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:141</i>
	 */
	void sass_option_push_plugin_path(SassLibrary.Sass_Options options, String path);
	/**
	 * Original signature : <code>void sass_option_push_include_path(Sass_Options*, const char*)</code><br>
	 * <i>native declaration : src/native/include/sass/context.h:145</i>
	 */
	void sass_option_push_include_path(SassLibrary.Sass_Options options, String path);
	public static class Sass_Function_Entry extends PointerType {
		public Sass_Function_Entry(Pointer address) {
			super(address);
		}
		public Sass_Function_Entry() {
			super();
		}
	};
	public static class Sass_Context extends PointerType {
		public Sass_Context(Pointer address) {
			super(address);
		}
		public Sass_Context() {
			super();
		}
	};
	public static class Sass_Importer_Entry extends PointerType {
		public Sass_Importer_Entry(Pointer address) {
			super(address);
		}
		public Sass_Importer_Entry() {
			super();
		}
	};
	public static class Sass_Value extends PointerType {
		public Sass_Value(Pointer address) {
			super(address);
		}
		public Sass_Value() {
			super();
		}
	};
	public static class Sass_Function_List extends PointerType {
		public Sass_Function_List(Pointer address) {
			super(address);
		}
		public Sass_Function_List() {
			super();
		}
	};
	public static class Sass_Options extends PointerType {
		public Sass_Options(Pointer address) {
			super(address);
		}
		public Sass_Options() {
			super();
		}
	};
	public static class Sass_Compiler extends PointerType {
		public Sass_Compiler(Pointer address) {
			super(address);
		}
		public Sass_Compiler() {
			super();
		}
	};
	public static class Sass_File_Context extends PointerType {
		public Sass_File_Context(Pointer address) {
			super(address);
		}
		public Sass_File_Context() {
			super();
		}
	};
	public static class Sass_Import_List extends PointerType {
		public Sass_Import_List(Pointer address) {
			super(address);
		}
		public Sass_Import_List() {
			super();
		}
	};
	public static class Sass_Importer_List extends PointerType {
		public Sass_Importer_List(Pointer address) {
			super(address);
		}
		public Sass_Importer_List() {
			super();
		}
	};
	public static class Sass_Import_Entry extends PointerType {
		public Sass_Import_Entry(Pointer address) {
			super(address);
		}
		public Sass_Import_Entry() {
			super();
		}
	};
	public static class Sass_Data_Context extends PointerType {
		public Sass_Data_Context(Pointer address) {
			super(address);
		}
		public Sass_Data_Context() {
			super();
		}
	};
}
