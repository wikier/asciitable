/* Copyright 2014 Sven van der Meer <vdmeer.sven@mykolab.com>
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

package de.vandermeer.asciitable.v2.render.width;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Utility to define the width of table columns using a fixed width for each column.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.1.2 build 150812 (12-Aug-15) for Java 1.7
 * @since      v0.0.5
 */
public class V2_WidthFixedColumns extends AbstractWidth {

	/** Column width array. */
	int[] ar;

	/**
	 * Returns a new table width calculator.
	 * Default internal array is set to size 1 (1 column) of width 0.
	 */
	public V2_WidthFixedColumns(){
		this.ar = new int[0];
	}

	/**
	 * Adds a column with the column width
	 * @param width column width in number of characters
	 * @return self to allow for chaining
	 */
	public V2_WidthFixedColumns add(int width){
		if(width>=3){
			this.ar = ArrayUtils.add(this.ar, width);
		}
		this.width += width;
		return this;
	}

	@Override
	public int[] getColumnWidths(int padding) {
		if(this.colNumber != (this.ar.length)){
			throw new IllegalArgumentException("wrong columns array length: columns array length must be the same as the columns used to initialise the table");
		}
		int[] ret = ArrayUtils.addAll(new int[0], this.ar);
		return ret;
	}

}
