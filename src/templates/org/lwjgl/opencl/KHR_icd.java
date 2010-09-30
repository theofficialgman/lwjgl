/*
 * Copyright (c) 2002-2010 LWJGL Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lwjgl.opencl;

import org.lwjgl.PointerBuffer;
import org.lwjgl.util.generator.*;
import org.lwjgl.util.generator.opencl.CLPlatformExtension;
import org.lwjgl.util.generator.opencl.cl_int;
import org.lwjgl.util.generator.opencl.cl_uint;

import java.nio.IntBuffer;

@CLPlatformExtension
@Extension(postfix = "KHR", className = "KHRICD")
public interface KHR_icd {

	/** Accepted as &lt;param_name&gt; to the function clGetPlatformInfo */
	int CL_PLATFORM_ICD_SUFFIX_KHR = 0x0920;

	/** Returned by clGetPlatformIDs when no platforms are found */
	int CL_PLATFORM_NOT_FOUND_KHR = -1001;

	@Optional(reason = "AMD Stream does not expose this (version tested: 2.2)")
	@cl_int
	int clIcdGetPlatformIDsKHR(@AutoSize(value = "platforms", canBeNull = true) @cl_uint int num_entries,
	                           @OutParameter @Check(canBeNull = true) @NativeType("cl_platform_id") PointerBuffer platforms,
	                           @OutParameter @Check(value = "1", canBeNull = true) @cl_uint IntBuffer num_platforms);

}