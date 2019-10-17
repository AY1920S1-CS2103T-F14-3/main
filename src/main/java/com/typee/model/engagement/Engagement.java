package com.typee.model.engagement;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a generalization of meetings, interviews and appointments.
 */
public abstract class Engagement {
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected AttendeeList attendees;
    protected Location location;
    protected String description;
    protected Priority priority;

    /**
     * Constructs an engagement.
     *
     * @param start start time of the engagement.
     * @param end end time of the engagement.
     * @param attendees list of people attending.
     * @param location location of the engagement.
     * @param description description of the engagement.
     * @param priority priority level of the engagement.
     */
    protected Engagement(LocalDateTime start, LocalDateTime end,
                         AttendeeList attendees, Location location, String description, Priority priority) {
        this.startTime = start;
        this.endTime = end;
        this.attendees = attendees;
        this.location = location;
        this.description = description;
        this.priority = priority;
    }

    /**
     * Returns a {@code Meeting}, {@code Interview}, or {@code Appointment} with the given fields.
     * @param type type of engagement.
     * @param start start time.
     * @param end end time.
     * @param attendees list of people attending.
     * @param location location of engagement.
     * @param description description of the engagement.
     * @param priority priority level of the engagement.
     *
     * @return an {@code Engagement} with the corresponding fields.
     */
    public static Engagement of(EngagementType type,
                                LocalDateTime start, LocalDateTime end,
                                AttendeeList attendees, Location location, String description,
                                Priority priority) {
        if (type.name().equalsIgnoreCase("meeting")) {
            return new Meeting(start, end, attendees, location, description, priority);
        } else if (type.name().equalsIgnoreCase("interview")) {
            return new Interview(start, end, attendees, location, description, priority);
        } else {
            return new Appointment(start, end, attendees, location, description, priority);
        }
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public AttendeeList getAttendees() {
        return attendees;
    }

    public void setAttendees(AttendeeList attendees) {
        this.attendees = attendees;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * Checks if this {@code Engagement} clashes with another one.
     *
     * @param engagement the {@code Engagement} to check for a clash.
     * @return true if there is a clash.
     */
    public boolean isSameEngagement(Engagement engagement) {
        return engagement.endTime.equals(endTime)
                && engagement.startTime.equals(startTime)
                && engagement.location.equals(location);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            // short-circuit.
            return true;
        } else if (o instanceof Engagement) {
            // type-cast Object and check for field equality.
            Engagement otherEngagement = (Engagement) o;
            return otherEngagement.location.equals(location)
                    && otherEngagement.attendees.equals(attendees)
                    && otherEngagement.description.equals(description)
                    && otherEngagement.startTime.equals(startTime)
                    && otherEngagement.endTime.equals(endTime)
                    && otherEngagement.priority.equals(priority);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime, location, description, attendees, priority);
    }
}
