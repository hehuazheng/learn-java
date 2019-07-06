package com.hzz;

import io.jaegertracing.internal.JaegerSpan;
import io.jaegertracing.internal.JaegerSpanContext;
import io.jaegertracing.internal.JaegerTracer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JaegerTracer tracer1 = getTracer();
        JaegerSpan span = tracer1.buildSpan("client").start();
        span.log("from client");
        span.setTag("traceId", span.context().getTraceId());

        JaegerSpanContext jsc = span.context();
        JaegerTracer tracer2 = getTracer();
        JaegerSpanContext spanContext = new JaegerSpanContext(jsc.getTraceIdHigh(), jsc.getTraceIdLow(),jsc.getSpanId(), jsc.getParentId(),  jsc.getFlags());
        JaegerSpan span2 = tracer2.buildSpan("server").asChildOf(spanContext).start();
        span2.setTag("myTag", "aaa");
        span2.finish();
        span.finish();
    }

    public static JaegerTracer getTracer() {
        io.jaegertracing.Configuration.SamplerConfiguration samplerConfiguration = io.jaegertracing.Configuration.SamplerConfiguration.fromEnv().withManagerHostPort("localhost:16686").withType("const").withParam(1);
        io.jaegertracing.Configuration.ReporterConfiguration reporterConfiguration = io.jaegertracing.Configuration.ReporterConfiguration.fromEnv().withLogSpans(true);
        io.jaegertracing.Configuration config = new io.jaegertracing.Configuration("testservice").withSampler(samplerConfiguration).withReporter(reporterConfiguration);
        return config.getTracer();
    }
}
