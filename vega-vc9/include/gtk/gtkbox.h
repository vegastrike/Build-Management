/* GTK - The GIMP Toolkit
 * Copyright (C) 1995-1997 Peter Mattis, Spencer Kimball and Josh MacDonald
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.	 See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

/*
 * Modified by the GTK+ Team and others 1997-1999.  See the AUTHORS
 * file for a list of people on the GTK+ Team.  See the ChangeLog
 * files for a list of changes.  These files are distributed with
 * GTK+ at ftp://ftp.gtk.org/pub/gtk/. 
 */

#ifndef __GTK_BOX_H__
#define __GTK_BOX_H__


#include <gdk/gdk.h>
#include <gtk/gtkcontainer.h>


#ifdef __cplusplus
extern "C" {
#endif /* __cplusplus */


#define GTK_TYPE_BOX            (gtk_box_get_type ())
#define GTK_BOX(obj)            (GTK_CHECK_CAST ((obj), GTK_TYPE_BOX, GtkBox))
#define GTK_BOX_CLASS(klass)    (GTK_CHECK_CLASS_CAST ((klass), GTK_TYPE_BOX, GtkBoxClass))
#define GTK_IS_BOX(obj)         (GTK_CHECK_TYPE ((obj), GTK_TYPE_BOX))
#define GTK_IS_BOX_CLASS(klass) (GTK_CHECK_CLASS_TYPE ((klass), GTK_TYPE_BOX))
#define GTK_BOX_GET_CLASS(obj)  (GTK_CHECK_GET_CLASS ((obj), GTK_TYPE_BOX, GtkBoxClass))


typedef struct _GtkBox	      GtkBox;
typedef struct _GtkBoxClass   GtkBoxClass;
typedef struct _GtkBoxChild   GtkBoxChild;

struct _GtkBox
{
  GtkContainer container;
  
  GList *children;
  gint16 spacing;
  guint homogeneous : 1;
};

struct _GtkBoxClass
{
  GtkContainerClass parent_class;
};

struct _GtkBoxChild
{
  GtkWidget *widget;
  guint16 padding;
  guint expand : 1;
  guint fill : 1;
  guint pack : 1;
};


GtkType	   gtk_box_get_type	       (void);
void	   gtk_box_pack_start	       (GtkBox	     *box,
					GtkWidget    *child,
					gboolean      expand,
					gboolean      fill,
					guint	      padding);
void	   gtk_box_pack_end	       (GtkBox	     *box,
					GtkWidget    *child,
					gboolean      expand,
					gboolean      fill,
					guint	      padding);
void	   gtk_box_pack_start_defaults (GtkBox	     *box,
					GtkWidget    *widget);
void	   gtk_box_pack_end_defaults   (GtkBox	     *box,
					GtkWidget    *widget);
void	   gtk_box_set_homogeneous     (GtkBox	     *box,
					gboolean      homogeneous);
void	   gtk_box_set_spacing	       (GtkBox	     *box,
					gint	      spacing);
void	   gtk_box_reorder_child       (GtkBox	     *box,
					GtkWidget    *child,
					gint	      position);
void	   gtk_box_query_child_packing (GtkBox	     *box,
					GtkWidget    *child,
					gboolean     *expand,
					gboolean     *fill,
					guint	     *padding,
					GtkPackType  *pack_type);
void	   gtk_box_set_child_packing   (GtkBox	     *box,
					GtkWidget    *child,
					gboolean      expand,
					gboolean      fill,
					guint	      padding,
					GtkPackType   pack_type);



#ifdef __cplusplus
}
#endif /* __cplusplus */


#endif /* __GTK_BOX_H__ */
