/*
 * Copyright (c) 2017 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package com.snowplowanalytics.dataflow.streaming
package storage

// Java
import org.joda.time.format.DateTimeFormat
import org.joda.time.DateTime

/**
 * Object uses downsampling method to create metadata from each
 * EventType log record. Parsing the ISO 8601
 * datetime stamp to the minute means downsampling aka reducing
 * precision.
 *
 * Bucketing
 * A family of aggregations that build buckets, where each bucket
 * is associated with a key and an EventType criterion. When the
 * aggregation is executed, all the buckets criteria are evaluated
 * on every EventType in the context and when a criterion matches,
 * the EventType is considered to "fall in" the relevant bucket.
 * By the end of the aggregation process, we’ll end up with a
 * list of buckets - each one with a set of EventTypes that
 * "belong" to it.
 *
 */
object BucketingStrategy {

  private val BucketToMinuteFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:00.000")

  /**
   * Function to bucket a date based on
   * our bucketing strategy. Bucketing
   * means downsampling aka reducing
   * precision.
   *
   * @param date The Java Date to bucket
   * @return the downsampled date in String
   *         print
   */
  def bucket(date: DateTime): String = BucketToMinuteFormatter.print(date)
} 
