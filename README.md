# Database Log Viewer
Visualize and filter the database log events

# API

## Arguments

### -host=?

The address representing the database server location

### -username=?

The username used to access the database

### -password=?

The password used to acess the database

### -template=basic

An optional template to be used to print the returned data. By default it uses the `basic` template.

## Templates

A template represents a coded routine to handle the persisted information and define it's output.

### basic

The default one, it prints some basic information for all log occurrences.

### failure

This template extends the `basic`, using the same printing style while providing a filter algorithm to ignore irrelevant results (like page not found or automatic exploit attempts).
